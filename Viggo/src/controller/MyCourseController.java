package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.FileTreeCreatorModel;
import model.MyCourseModel;
import model.ServerCommunicatorModel;
import view.MyCourseView;

public class MyCourseController {
	
	private MyCourseView myCourseView;
	private MyCourseModel myCourseModel;
	private FileTreeCreatorModel fileTreeCreatorModel;

	public MyCourseController(MyCourseView myCourseView, MyCourseModel myCourseModel) {
		this.myCourseView = myCourseView;
		this.myCourseModel = myCourseModel;
		this.fileTreeCreatorModel = new FileTreeCreatorModel(myCourseModel);
		this.myCourseView.getWestPanel().setTree(fileTreeCreatorModel.makeTree((String)myCourseModel.getCaching().getValueAt(0, 5)));
		this.myCourseView.setVisible(true);
	}
	
	class MyCourseListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String arg = e.getActionCommand();
			if(arg.equals("Se oppgaver")) {
				
			}
			else if(arg.equals("Lukk program")){
				
			}
		}
	}

}
