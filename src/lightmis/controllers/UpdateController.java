package lightmis.controllers;

import java.util.LinkedList;
import java.util.List;

import lightmis.listener.UpdateListener;

public abstract class UpdateController {
	
	private List<UpdateListener> updateListenerList =
			new LinkedList<UpdateListener>();
	
	public void addUpdateListener(UpdateListener listener) {
		updateListenerList.add(listener);
	}
	
	public void removeUpdateListener(UpdateListener listener) {
		updateListenerList.remove(listener);
	}
	
	protected void notifyUpdate() {
		for (UpdateListener listener : updateListenerList)
			listener.update();
	}
	
}
