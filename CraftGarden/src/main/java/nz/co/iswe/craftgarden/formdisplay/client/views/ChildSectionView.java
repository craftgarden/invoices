package nz.co.iswe.craftgarden.formdisplay.client.views;

import com.google.gwt.user.client.ui.IsWidget;

public interface ChildSectionView  extends IsWidget{

	public interface Presenter{
		void remove(int index);
	}
	
	void setPresenter(Presenter presenter);
	
	void setVisible(boolean b);

	void setIndex(int index);

	void focus();
}
