import java.util.Random;

public class Addressee implements Runnable {
  private int id;
  private Paczkomat paczkomat;
  private Package aPackage;
  private Receiver receiver;
  private Random rand = new Random();

  Addressee(int id, Paczkomat paczkomat){
    this.id = id;
    this.paczkomat = paczkomat;

    aPackage = new Package(rand.nextInt(1000));

    receiver = new Receiver(rand.nextInt(1000),aPackage.getPac_no(),this.paczkomat);


    System.out.println("Ja adresat " + this.id + " istnieje");


  }

  @Override
  public void run() {
    final Receiver receiver = paczkomat.putPackage(aPackage, this.receiver);

    if(receiver == null){
      System.out.println("Paczkomat nr " + paczkomat.getPaczkomat_no() + " jest przepelniony");
      return;
    }
    System.out.println("Adresat nr. " + id + " nadal paczke nr. " + aPackage.getPac_no() + " do odbiorcy nr. " + receiver.getId());


  }
}
