# iOS Calculator
The iOS calculator, built with Java is a GUI application that mimics the default iOS basic calculator. It provides the same core functionality and visual, allowing uses to perform simple operations and clearing data when needed. 

# 🛠 Qualities
- **Fast Performance**: Calculations can be executed with quick, simple clicks, just like a real-world calculator.
- **Correct Calculations**: All calculations have considered edge cases for users to receive accurate results.
- **Easy to use**: Interface is direct, user-friendly and mimics the minimalism of iOS calculator. 

# 🛠 Features
- **Dynamic Buttons**: Click any digit, operators or symbols to help you build your mathematical expressions.
- **A/C Button**: Like a usual calculator, the All Clear (AC) button helps clear any past data that was stored and resets to default state.
- **+/- Button**: Easily toggle for current values between positive and negative depending on your needs.

# 📜 Project Process
Using iOS Calculator on the iPhone was the main inspiration and tool in projecting a design behind this GUI interface. A GUI application needs to use the minimum core modules of Java Swing and AWT. 

Creating a calculator would mean to create the basic window with similar dimensions of the iOS Calculator App and researching the color palette that was used. This includes:
| Color | RGB |
| :--- | :---: | 
| LightGray | 212, 212, 210 |
| DarkGray | 80, 80, 80 |
| Black | 28, 28, 28 |
| Orange | 255, 149, 0 |

To mimic the calculator, it must include the basic buttons of operators and digits for the basic calculations. Hence, this meant gathering each button 'values' that would appear into an Array which will hold onto each values for later iteration. However, as seen in a iOS Calculator App, certain symbols may have different colors. Hence, each array groups their color distinction too. 

As a basic GUI interface, creating the window, frame, panels were essential for base framework. On top of it, creating button panels were essential but was done through an iteration for loop in button values array. This method helps minimalize code work and make code program-friendly for others to look and run. Based on comparison of different arrays, color distinction was done to match the original iOS Calculator display. 

Buttons have interaction with users' cursor. Therefore, action listener was used to get event source on which button was clicked and lets the program store specific values when calculations are on going. Depending on the operator chosen, we compare the 2 variables that were given and stored, to perform calculations behind the scene and display the result onto the panel. 

There are many edge cases that were prevented to mimic how iOS Calculator App functions and how logically expressions should look such as removing unecessary decimal places for whole numbers, having trailing zeros at the start of numbers and multiple operators being clicked at once. 

# 📓 What I've Learned
- **Implementation of Array Iterations in GUI Interfaces**: I've learned GUI interface fundamentals and collections seperately but never cooperated them in one project. This project allowed me to build a wider vision on how projects can be made and using collections to simplify work
- **ActionListener & ActionEvent**: Using action listener to get button clicking source and using this source to store data into variables for later calculations
- **Considering edge cases**: This helped me improve my logistic thinking and problem-solving skills through considering out of boxes scenarios that could occur and to resolve them.

> [!WARNING]
> Creator is aware of division by zero edge case and exceptions have not been made. Square root button have not been implemented yet.

## Credits
Base logic provided by [Kenny Yip Coding](https://www.youtube.com/@KennyYipCoding) under the MIT License.


