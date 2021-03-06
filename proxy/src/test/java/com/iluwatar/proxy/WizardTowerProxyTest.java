package com.iluwatar.proxy;

import org.junit.Test;
import org.mockito.InOrder;

import static org.mockito.Mockito.inOrder;

/**
 * Date: 12/28/15 - 9:18 PM
 *
 * @author Jeroen Meulemeester
 */
public class WizardTowerProxyTest extends StdOutTest {

  @Test
  public void testEnter() throws Exception {
    final Wizard[] wizards = new Wizard[]{
        new Wizard("Gandalf"),
        new Wizard("Dumbledore"),
        new Wizard("Oz"),
        new Wizard("Merlin")
    };

    final WizardTowerProxy tower = new WizardTowerProxy();
    for (final Wizard wizard : wizards) {
      tower.enter(wizard);
    }

    final InOrder inOrder = inOrder(getStdOutMock());
    inOrder.verify(getStdOutMock()).println("Gandalf enters the tower.");
    inOrder.verify(getStdOutMock()).println("Dumbledore enters the tower.");
    inOrder.verify(getStdOutMock()).println("Oz enters the tower.");
    inOrder.verify(getStdOutMock()).println("Merlin is not allowed to enter!");
    inOrder.verifyNoMoreInteractions();

  }

}