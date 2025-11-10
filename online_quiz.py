from tkinter import *
from tkinter import messagebox

# Create main window
root = Tk()
root.title("Online Quiz")
root.geometry("400x400")

# Heading
Label(root, text="Online Quiz", font=("Arial", 16, "bold")).pack(pady=10)

# Question 1
Label(root, text="1) Which language is used for web development?", font=("Arial", 12)).pack(anchor="w", padx=10, pady=5)

q1_var = StringVar()
Checkbutton(root, text="Python", variable=q1_var, onvalue="Python", offvalue="").pack(anchor="w", padx=20)
Checkbutton(root, text="HTML", variable=q1_var, onvalue="HTML", offvalue="").pack(anchor="w", padx=20)
Checkbutton(root, text="C++", variable=q1_var, onvalue="C++", offvalue="").pack(anchor="w", padx=20)

# Question 2
Label(root, text="2) What is the capital of India?", font=("Arial", 12)).pack(anchor="w", padx=10, pady=5)

q2_var = StringVar()
Checkbutton(root, text="Mumbai", variable=q2_var, onvalue="Mumbai", offvalue="").pack(anchor="w", padx=20)
Checkbutton(root, text="New Delhi", variable=q2_var, onvalue="New Delhi", offvalue="").pack(anchor="w", padx=20)
Checkbutton(root, text="Kolkata", variable=q2_var, onvalue="Kolkata", offvalue="").pack(anchor="w", padx=20)

# Function to submit quiz
def submit_quiz():
    score = 0
    if q1_var.get() == "HTML":
        score += 1
    if q2_var.get() == "New Delhi":
        score += 1

    messagebox.showinfo("Result", f"Your Score: {score}/2")

# Submit button
Button(root, text="Submit", command=submit_quiz).pack(pady=20)

root.mainloop()
