export class Schueler{


  public schueler_id: number;
  public vorname: string;
  public nachname: string;
  klassen_id: number;
  geburtsdatum: Date;
  email: string;
  telefonnummer: string;

  public constructor(schueler_id: number, vorname: string, nachname: string, klassen_id: number, geburtsdatum: Date, email: string, telefonnummer: string) {
    this.schueler_id = schueler_id;
    this.vorname = vorname;
    this.nachname = nachname;
    this.klassen_id = klassen_id;
    this.geburtsdatum = geburtsdatum;
    this.email = email;
    this.telefonnummer = telefonnummer;
  }
  }

