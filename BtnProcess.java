import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BtnProcess extends NewCal
{
	private String num1 = null;
	private String symbol = null;
	private int isCaling = 0, isAC=0; //AC = AfterCaling
	private double ans = 0;
	BtnProcess()
	{
		
	}

	public void changeColor(JButton btn, String status)
	{
		if(status == "light")
		{
			//btn.setBackground(new Color(184, 207, 229));
			btn.setBorder(BorderFactory.createLineBorder(Color.black,2));
		}else
		{
			//btn.setBackground(Color.GRAY);		
			btn.setBorder(BorderFactory.createEmptyBorder());
			btn.setBorder(BorderFactory.createLineBorder(Color.black,1));
			System.out.println("color changed");
		}
	}

	public void checkType(String text)
	{

		if(text.startsWith("b"))
		{
			//System.out.println("Call Binary");
			text = text.replace("b","");
			if(num1 != null && num1.equals(label.getText()))
			{
				//no exe
				symbol = text;
				System.out.println("equals");
			}else
			{
				//exe
				System.out.println("not equals");
				text = text.replace("b","");
				if(isCaling == 1)
				{
					bin(text);
				}else
				{
					//System.out.println("not caling "  + num1 + text);
					num1 = label.getText();
					isCaling = 1;
				}
				isAC = 1;
				symbol = text;
			}
		}else if(text.startsWith("u"))
		{
			//System.out.println("Call Unary");
			text = text.replace("u","");
			una(text);
		}else if(text.startsWith("C"))
		{
			//System.out.println("This is Clear");
			label.setText("0");
			num1 = null;
			symbol = null;
			isCaling = 0;
			ans = 0;
			isAC = 0;
		}else if(text.startsWith("."))
		{
			//System.out.println("This is a dot");
			System.out.println("\n" + isAC);
			if(isAC == 1)
			{
				label.setText("0.");
				isAC = 0;
			}else if(!label.getText().contains("."))
			{
				label.setText(label.getText() + ".");
			}

		}else if(text.startsWith("del"))
		{
			//do
			if (label.getText().length() == 1) 
			{
				label.setText("0");
			}else
			{
				label.setText(label.getText().substring(0,label.getText().length()-1));
			}
			
		}else if(text.startsWith("="))
		{
			//System.out.println("This is a Equal Sign");
			if(isCaling == 1)
			{
				isCaling = 0;
				bin(text);
			}
			isAC = 1;
			symbol = null;

		}else
		{
			//System.out.println("This is a Number " + text);
			if(label.getText().equals("0"))
			{
				label.setText(text);
			}else
			{
				if(isAC == 1)
				{
					label.setText(text);
					isAC = 0;
				}else
				{
					label.setText(label.getText() + text);
				}
			}
		}
	}


	public void bin(String text)
	{
			switch (symbol) 
			{
				case "+":
					ans = Double.valueOf(num1) + Double.valueOf(label.getText());
					break;
				case "-":
					ans = Double.valueOf(num1) - Double.valueOf(label.getText());
					break;
				case "X":
					ans = Double.valueOf(num1) * Double.valueOf(label.getText());
					break;
				case "÷":
					ans = Double.valueOf(num1) / Double.valueOf(label.getText());
					break;
				case "^":
					ans = Math.pow(Double.valueOf(num1), Double.valueOf(label.getText()));
					break;
				default:
					label.setText("Error");
					break;
			}

			System.out.print("\n" + num1 + " " +  symbol + " " + label.getText() + " = " + ans + "\n");

			if(ans % 1.0 == 0)
				label.setText(String.valueOf(ans).replace(".0",""));
			else
				label.setText(String.valueOf(ans));
			num1 = String.valueOf(ans);
	}

	public void una(String text)
	{
		//
		switch(text)
		{
			case "√":
			ans = Math.sqrt(Double.valueOf(label.getText()));
			break;
			case "1/x":
 			ans = 1 / Double.valueOf(label.getText());
 			break;
 			case "x!":
 			ans = 1;
 			for (int i = 1; i <= Double.valueOf(label.getText()); i++) {
 				ans *= i; 
 			}
 			break;
 			case "log":
 			ans = Math.log10(Double.valueOf(label.getText()));
 			break;
			case "sin":
			if(Double.valueOf(label.getText()) % 180 == 0)
				ans = 0;
			else
				ans = Math.sin(Math.toRadians(Double.valueOf(label.getText())));
			break;
			case "cos":
			if(Double.valueOf(label.getText()) % 180 == 90)
				ans = 0;
			else
				ans = Math.cos(Math.toRadians(Double.valueOf(label.getText())));
			break;

			case "tan":
			//ans = Math.tan(Math.toRadians(Double.valueOf(label.getText())));
			ans = (Math.sin(Math.toRadians(Double.valueOf(label.getText()))) / Math.cos(Math.toRadians(Double.valueOf(label.getText()))));
			break;

			case "+/-":
			if(label.getText().contains("-"))
			{
				label.setText(label.getText().replace("-", ""));
				System.out.println(label.getText());
			}
			else
			{
				label.setText("Hello");
				System.out.println("without" + label.getText());
			}
			break;

			default:
			System.out.println("Default");
		}

		if(ans % 1.0 == 0)
		{
			label.setText(String.valueOf(ans).replace(".0",""));
		}
		else
		{
			label.setText(String.valueOf(ans));
		}

		isAC = 1;
	}
}