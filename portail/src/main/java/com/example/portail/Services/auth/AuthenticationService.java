package com.example.portail.Services.auth;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.portail.Repositories.UserRepo;
import com.example.portail.Security.JwtService;
import com.example.portail.Utils.EmailService;
import com.example.portail.models.Role;
import com.example.portail.models.User;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.AddressException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class AuthenticationService {
  private final UserRepo userRepo;
  private final PasswordEncoder passwordEncoder;
  private final JwtService jwtService;
  private final AuthenticationManager authenticationManager;
  private final EmailService emailService;

  public ResponseEntity<?> register(RegisterRequest request) {
    Optional<User> user = userRepo.findByEmail(request.getEmail());
    if (user.isPresent() && user.get().getStatus() == 1) {
      return ResponseEntity.badRequest().body("Email deja utilisé, votre demande est en cours!");
    }
    User user1 = User.builder()
        .nom_utilisateur(request.getUsername())
        .password(passwordEncoder.encode(request.getPassword()))
        .email(request.getEmail())
        .firstName(request.getFirstName())
        .lastName(request.getLastName())
        .birthday(request.getBirthday())
        .genre(request.getGenre())
        .status(1)
        .role(Role.ROLE_EMPLOYEE)
        .build();
    userRepo.save(user1);
    return ResponseEntity.ok("demande envoyée!");
  }

  public ResponseEntity<?> authenticate(AuthenticationRequest request) {
    try {
      authenticationManager.authenticate(
          new UsernamePasswordAuthenticationToken(
              request.getMatricule(),
              request.getPassword()));
    } catch (BadCredentialsException ex) {
      return ResponseEntity.status(403).body("Account disabled!");
    }
    var user = userRepo.findByMatricule(request.getMatricule())
        .orElseThrow(() -> new IllegalStateException("Something went wrong!"));
    var jwtToken = jwtService.generateToken(user);
    return ResponseEntity.ok(AuthenticationResponse.builder().token(jwtToken).build());
  }

  public ResponseEntity<?> acceptEmployee(long id_employee) throws AddressException, MessagingException {
    User user = userRepo.findById(id_employee).get();
    user.setStatus(3);
    String matricule = getRandomUniqueMatricule();
    user.setMatricule(matricule);
    emailService.sendEmail(user.getEmail(), "demande acceptée",
        "Votre demande a été acceptée voici votre matricule d'accès: " + user.getMatricule());
    return ResponseEntity.ok("ok!");
  }

  public ResponseEntity<?> declineEmployee(long id_employee) throws AddressException, MessagingException {
    User user = userRepo.findById(id_employee).get();
    user.setStatus(2);
    emailService.sendEmail(user.getEmail(), "demande rejetée",
        "Malheureusement votre demande a été rejetée, vous pouvez essayer plus tard!");
    return ResponseEntity.ok("ok!");
  }

  public String getRandomUniqueMatricule() {
    return UUID.randomUUID().toString().substring(0, 8);
  }

  public ResponseEntity<?> addAdmin(RegisterRequest request) {
    User user = User.builder()
        .nom_utilisateur(request.getUsername())
        .password(passwordEncoder.encode(request.getPassword()))
        .email(request.getEmail())
        .firstName(request.getFirstName())
        .lastName(request.getLastName())
        .birthday(request.getBirthday())
        .genre(request.getGenre())
        .status(3)
        .matricule("123456789")
        .role(Role.ROLE_ADMIN)
        .build();
    userRepo.save(user);
    return ResponseEntity.ok("admin inséré!");
  }

  public ResponseEntity<List<User>> getAllUsers() {
    return ResponseEntity
        .ok(userRepo.findAll().stream().filter(user -> user.getRole().equals(Role.ROLE_EMPLOYEE)).toList());
  }

}
