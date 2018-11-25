package com.robot;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.KeyEvent;
import java.io.IOException;



public class JavaRobotNotepad {

	public static void main(String args[]) throws Exception {
		
		Robot robot = new Robot();	
		robot.delay(2000);
		robot.keyPress(KeyEvent.VK_WINDOWS);
		robot.keyRelease(KeyEvent.VK_WINDOWS);
		robot.delay(1000);
		/*robot.keyPress(KeyEvent.VK_C);
		robot.keyRelease(KeyEvent.VK_C);
		robot.keyPress(KeyEvent.VK_A);
		robot.keyRelease(KeyEvent.VK_A);
		robot.keyPress(KeyEvent.VK_L);
		robot.keyRelease(KeyEvent.VK_L);
		robot.keyPress(KeyEvent.VK_C);
		robot.keyRelease(KeyEvent.VK_C);*/
		type(robot,"calc");
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.delay(1000);
		robot.keyPress(KeyEvent.VK_2);
		robot.keyRelease(KeyEvent.VK_2);
		robot.delay(1000);
		robot.keyPress(KeyEvent.VK_ADD);
		robot.keyRelease(KeyEvent.VK_ADD);
		robot.keyPress(KeyEvent.VK_3);
		robot.keyRelease(KeyEvent.VK_3);
		robot.delay(1000);
		robot.keyPress(KeyEvent.VK_EQUALS);
		robot.keyRelease(KeyEvent.VK_EQUALS);
		robot.delay(2000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_C);
		robot.keyRelease(KeyEvent.VK_C);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Clipboard cp = toolkit.getSystemClipboard();
		String result = (String) cp.getData(DataFlavor.stringFlavor);
		
		if(result.equals("5")){
			System.out.println(result);
		} else {
			throw new Exception("Result is not matched");
		}
		
		
		robot.keyPress(KeyEvent.VK_ALT);
		robot.keyPress(KeyEvent.VK_F4);
		robot.keyRelease(KeyEvent.VK_F4);
		robot.keyRelease(KeyEvent.VK_ALT);
		
		
	}
	public static void type(Robot robot , String value){
		
		for (int i = 0; i < value.length(); i++) {
	        char c = value.charAt(i);
	        robot.keyPress(Character.toUpperCase(c));
	        robot.keyRelease(Character.toUpperCase(c));

	    }
		
		robot.delay(1000);
		
	}

}
