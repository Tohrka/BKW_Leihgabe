export class Gereat{
  public seriennummer: number;
  public marke: string;
  public modell: string;
  public schaeden: string;
  public baujahr: number;
  public status: string;

  public constructor(seriennummer: number, marke: string, modell: string, schaeden: string, baujahr: number, status: string) {
    this.seriennummer = seriennummer;
    this.marke = marke;
    this.modell = modell;
    this.schaeden = schaeden;
    this.baujahr = baujahr;
    this.status = status;

  }
}
