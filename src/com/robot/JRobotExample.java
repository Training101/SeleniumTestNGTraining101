package com.robot;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class JRobotExample {

	public static void main(String[] args) {
		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_WINDOWS);
			robot.keyRelease(KeyEvent.VK_WINDOWS);
			robot.delay(1000);
			robot.keyPress(KeyEvent.VK_C);
			robot.keyRelease(KeyEvent.VK_C);
			robot.keyPress(KeyEvent.VK_A);
			robot.keyRelease(KeyEvent.VK_A);
			robot.keyPress(KeyEvent.VK_L);
			robot.keyRelease(KeyEvent.VK_L);
			robot.keyPress(KeyEvent.VK_C);
			robot.keyRelease(KeyEvent.VK_C);
			
			robot.keyPress(KeyEvent.VK_ALT);
			robot.keyPress(KeyEvent.VK_F4);
			robot.keyRelease(KeyEvent.VK_F4);
			robot.keyRelease(KeyEvent.VK_ALT);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
