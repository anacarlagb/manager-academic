package br.puc.inf.pss;

import org.jooby.Jooby;

import br.puc.inf.pss.controller.ManagerAcademicController;

/**
 * @author jooby generator
 */
public class App extends Jooby {

  {
    get("/", () -> "Hello World!");
    
    use(ManagerAcademicController.class);
  }

  public static void main(final String[] args) {
    run(App::new, args);
  }

}
