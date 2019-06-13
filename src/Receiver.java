import java.util.Random;

public class Receiver implements Runnable {
  private int id;
  private int pac_no;
  private Paczkomat paczkomat;

  Receiver(int id, int pac_no, Paczkomat paczkomat){
    this.id = id;
    this.pac_no = pac_no;
    this.paczkomat = paczkomat;

    System.out.println("Ja odbiorca " + this.id + " istnieje");
  }

  int getId(){
    return id;
  }

  int getPac_no(){
    return pac_no;
  }

  @Override
  public void run() {
    paczkomat.getPackage(paczkomat, pac_no, id);

  }
}
