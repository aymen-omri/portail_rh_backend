export interface DemandeConge {
  id: number;
  dateDebut: Date;
  dateFin: Date;
  type: string;
  raison: string;
  statut_demande: string;
  dateSoumission: Date;
  dateAcceptation: Date;
  dateRejet: Date;
}
