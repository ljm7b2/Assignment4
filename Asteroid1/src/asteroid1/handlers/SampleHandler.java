package asteroid1.handlers;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;

import asteroid1.Game;
import asteroid1.iBullet;
import asteroid1.iClock;
import asteroid1.iPlayer;

/**
 * Our sample handler extends AbstractHandler, an IHandler base class.
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class SampleHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		
		Game.main(evaluateExtension());
		return null;
	}
	
	  private Map<String, String> evaluateExtension() {
		  int count = 0;
		  Map<String, String> GameArgs = new HashMap<String,String>();

			IConfigurationElement[] config = Platform.getExtensionRegistry()
					.getConfigurationElementsFor("Asteroid.ext1");
			try {
				for (IConfigurationElement e : config) {
					System.out.println("Evaluating extension: " + e.getAttributeNames()[0]);					
					final Object o = e.createExecutableExtension(e.getAttributeNames()[0]);
					
					
					if (o instanceof iPlayer) {
						count++;
						
						GameArgs.put("max_velocity", ((iPlayer) o).SetMaxVelocity());
						GameArgs.put("rotation_speed", ((iPlayer) o).SetRotationSpeed());
						GameArgs.put("max_bullets", ((iPlayer) o).SetMaxBullets());
						GameArgs.put("fire_rate", ((iPlayer) o).SetFireRate());

					}
					else if (o instanceof iClock) {
						count++;
						
						GameArgs.put("cycles_per_second", ((iClock) o).SetCyclesPerSecond());

					}
					else if(o instanceof iBullet){
						count++;
						
						GameArgs.put("velocity_magnitude", ((iBullet) o).SetVelocityMagnitude());
						GameArgs.put("max_lifespan", ((iBullet) o).SetMaxLifeSpan());
						
					}					
				}
				
			return GameArgs;
			} catch (CoreException ex) {
				System.out.println(ex.getMessage());
				return null;
			}
	  }
}
