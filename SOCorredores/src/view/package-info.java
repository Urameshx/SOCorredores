package view;

import java.util.concurrent.Semaphore;

import controller.PersonController;

class Principal {
  public static void main(String[] args) {
    Semaphore semaphore = new Semaphore(1);

    for (int id_person = 1; id_person <= 4; id_person++) {
      PersonController person = new PersonController(id_person, semaphore);
      person.start();
    }
  }
}