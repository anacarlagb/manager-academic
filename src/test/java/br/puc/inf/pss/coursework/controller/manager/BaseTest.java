package br.puc.inf.pss.coursework.controller.manager;


import org.jooby.test.Client;
import org.jooby.test.JoobyRule;
import org.junit.ClassRule;
import org.junit.Rule;

import br.puc.inf.pss.App;

/**
 * @author jooby generator
 */
public class BaseTest {

  /**
   * One app/server for all the test of this class. If you want to start/stop a new server per test,
   * remove the static modifier and replace the {@link ClassRule} annotation with {@link Rule}.
   */
   @ClassRule
   public static JoobyRule app = new JoobyRule(new App());

  /**
   * One client per test. It creates a new HTTP client per each of the test method you have.
   */
  @Rule
  public Client server = new Client("http://localhost:8080");

}
