package asteroidplugin1.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.ISafeRunnable;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.SafeRunner;
import asteroidplugin1.main.Game;
import asteroidplugin1.handlers.AsteroidPlugin1Interface;

/**
 * Our sample handler extends AbstractHandler, an IHandler base class.
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class SampleHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
//		MessageDialog.openInformation(
//				window.getShell(),
//				"AsteroidPlugin1",
//				"Hello, Eclipse world");
		Game.main(null);
		return null;
	}
	

	  private void evaluateExtension() {

			IConfigurationElement[] config = Platform.getExtensionRegistry()
					.getConfigurationElementsFor("AsteroidPlugin1.Ext1");
			try {
				for (IConfigurationElement e : config) {
					System.out.println("Evaluating extension");
					final Object o = e.createExecutableExtension("class");
					if (o instanceof AsteroidPlugin1Interface) {
						executeExtension(o);
					}
				}
			} catch (CoreException ex) {
				System.out.println(ex.getMessage());
			}
		}
	  
      private void executeExtension(final Object o) {
          ISafeRunnable runnable = new ISafeRunnable() {
                  @Override
                  public void handleException(Throwable e) {
                          System.out.println("Exception in client");
                  }

                  @Override
                  public void run() throws Exception {
                          ((AsteroidPlugin1Interface) o).NewObject(60);
                  }
          };
          SafeRunner.run(runnable);
  }
}
