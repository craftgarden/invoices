package nz.co.iswe.craftgarden.formdisplay.client.views;

import com.google.gwt.user.client.ui.IsWidget;

public interface DisplayFormView  extends IsWidget{

	public interface Presenter extends ChildSectionView.Presenter{
		
	}
	
	void setPresenter(Presenter presenter);
	
	void setVisible(boolean b);

	void removeChildSection(int index);

}
