from tkinter import *

# Create main window
root = Tk()
root.title("Welcome Screen")
root.geometry("400x250")

# Heading
Label(root, text="Welcome to Our Application", font=("Arial", 16, "bold")).pack(pady=40)

# Subtext
Label(root, text="We’re glad to have you here!", font=("Arial", 12)).pack(pady=10)

# Button to continue
def proceed():
    Label(root, text="Thank you! Proceeding...", font=("Arial", 11)).pack(pady=10)

Button(root, text="Get Started", width=15, command=proceed).pack(pady=20)

root.mainloop()
