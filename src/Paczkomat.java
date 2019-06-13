import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class Paczkomat {
  private int paczkomat_no;
  private Map<Integer, Package> packages = new HashMap<>();
  private Package aPackage;
  private Receiver receiver;
  private Random rand = new Random();
  private Semaphore sem = new Semaphore(1, true);

  Paczkomat(int paczkomat_no) {
    this.paczkomat_no = paczkomat_no;
  }

  public int getPaczkomat_no(){
    return paczkomat_no;
  }

  public Receiver putPackage(Package aPackage, Receiver receiver) {
    if (packages.size() == 20) {
      return null;
    }



    try {
      sem.acquire();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }


    this.aPackage = aPackage;

    packages.put(this.aPackage.getPac_no(), this.aPackage);



    System.out.println();

    System.out.println("ILOSC PACZEK W PACZKOMACIE "+ packages.size());

    this.receiver = receiver;

    Thread thread = new Thread(receiver);
    thread.start();

    try {
      Thread.sleep(rand.nextInt(1000));
    } catch (InterruptedException e) {
      e.printStackTrace();
    }



    sem.release();





    return receiver;
  }

  public void getPackage(Paczkomat paczkomat, int pac_no, int id){
    if(packages.size() == 0){
      System.out.println("Paczkomat nr " + paczkomat.getPaczkomat_no() + " jest pusty");
      return;
    }

    try {
      sem.acquire();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }


    packages.remove(pac_no);


    System.out.println();

    System.out.println("Pacczka nr. " + pac_no + " zostala wyjeta przez odbiorce " + id);

    System.out.println("ILOSC PACZEK W PACZKOMACIE "+ packages.size());

    sem.release();

  }

}
