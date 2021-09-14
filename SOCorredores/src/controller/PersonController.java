package controller;

import java.util.concurrent.Semaphore;

public class PersonController extends Thread {
  private Semaphore semaphore;
  private int id_person;
  private int dist_percorrida = 0;

  public PersonController(int id_person, Semaphore semaphore) {
    this.semaphore = semaphore;
    this.id_person = id_person;
  }

  @Override
  public void run() {
    try {
      do {
        Andar();
      } while (dist_percorrida <= 200);

      semaphore.acquire();
      AbrirPorta();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      semaphore.release();
    }
  }

  private void Andar() {
    int passos = (int) (Math.random() * (7 - 4)) + 4;
    dist_percorrida += passos;
    System.out.println("A pessoa nº" + id_person + " andou " + passos + " metros. A distância total percorrida foi de: " + dist_percorrida + " metros");
  }

  private void AbrirPorta() {
    System.out.println("A pessoa nº" + id_person + " abriu a porta.");

    int porta_aberta = (int) (Math.random() * (3 - 1)) + 1;
     
    try {
      sleep(porta_aberta * 1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.out.println("A pessoa nº" + id_person + " fechou a porta.");
  }
  
}