package Question12;

//This file is used to test ViewCreate
//Your code must run well with this startup without modifying this file
public class GUI2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Library lib = new Library("UIC Library");

				ControllerSimple cs = new ControllerSimple(lib);
				ViewSimple vs = new ViewSimple(lib, cs);
				
				ControllerGetBook cgb = new ControllerGetBook(lib);
				ViewGetBook vgb = new ViewGetBook(lib, cgb);
				
				ControllerMoreBook cmb = new ControllerMoreBook(lib);
				ViewMoreBook vmb = new ViewMoreBook(lib, cmb);
				
				ControllerHistory ch = new ControllerHistory(lib);
				ViewHistory vh = new ViewHistory(lib, ch);
				
				ControllerCreate cc = new ControllerCreate(lib);
				ViewCreate vc = new ViewCreate(lib, cc);				
			}
		});
	}

}

