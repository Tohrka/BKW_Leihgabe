export class Klasse{
  public klassen_id: number;
  public klassenname: string;
  public leher_id: number;
  public constructor(klassen_id: number, klassenname: string, leher_id: number) {
    this.klassen_id = klassen_id;
    this.klassenname = klassenname;
    this.leher_id = leher_id;
  }
}
