import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Semaphore;

class Paczkomat {
  private int paczkomat_no;
  private Map<Integer, Package> packages = new HashMap<>();
  private Random rand = new Random();
  private Semaphore sem = new Semaphore(1, true);

  Paczkomat(int paczkomat_no) { this.paczkomat_no = paczkomat_no; }

  int getPaczkomat_no(){ return paczkomat_no; }

  Receiver putPackage(Package aPackage, Receiver receiver) {
    try {
      sem.acquire();
      Thread.sleep(1000);

      if (packages.size() >= 20) { return null; }

      packages.put(aPackage.getPac_no(), aPackage);

      System.out.println();
      System.out.println("ILOSC PACZEK W PACZKOMACIE "+ " nr. " + paczkomat_no + " to " + packages.size());

      Thread thread = new Thread(receiver);
      thread.start();

      try {
        Thread.sleep(rand.nextInt(1000));
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      sem.release();
    }
    return receiver;
  }

  void getPackage(Paczkomat paczkomat, int pac_no, int id){
    try {
      sem.acquire();
      Thread.sleep(1000);

      if(packages.size() == 0){
        System.out.println();
        System.out.println("Paczkomat nr " + paczkomat.getPaczkomat_no() + " jest pusty");
        return;
      }

      packages.remove(pac_no);

      System.out.println();
      System.out.println("ILOSC PACZEK W PACZKOMACIE "+ " nr. " + paczkomat_no + " to " + packages.size() );
      System.out.println("Paczka nr. " + pac_no + " zostala wyjeta przez odbiorce " + id + " z paczkomatu nr. "+ paczkomat_no);

    } catch (InterruptedException e) {
      e.printStackTrace();
    }finally {
      sem.release();
    }
  }
}
