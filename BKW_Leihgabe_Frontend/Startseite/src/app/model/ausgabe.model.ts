export class Ausgabe{
  public schueler_id: number;
  public seriennummer: number;
  public ausgabe_ab: Date;
  public ausgabe_bis: Date;

  public constructor(schueler_id: number, seriennummer: number, ausgabe_ab: Date, ausgabe_bis: Date) {
    this.schueler_id = schueler_id;
    this.seriennummer = seriennummer;
    this.ausgabe_ab = ausgabe_ab;
    this.ausgabe_bis = ausgabe_bis;
  }
}
