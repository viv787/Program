from tkinter import *
from tkinter import messagebox

# Create main window
root = Tk()
root.title("Login Window")
root.geometry("350x220")

# Heading
Label(root, text="Login Window", font=("Arial", 16, "bold")).pack(pady=15)

# Username label and entry
Label(root, text="Username:").pack()
username_var = StringVar()
Entry(root, textvariable=username_var, width=30).pack(pady=5)

# Password label and entry
Label(root, text="Password:").pack()
password_var = StringVar()
Entry(root, textvariable=password_var, show="*", width=30).pack(pady=5)

# Function to check login
def login():
    username = username_var.get()
    password = password_var.get()

    if username == "" or password == "":
        messagebox.showerror("Error", "Please fill all fields")
    elif username == "admin" and password == "1234":
        messagebox.showinfo("Login Successful", f"Welcome, {username}!")
    else:
        messagebox.showerror("Error", "Invalid Username or Password")

# Login button
Button(root, text="Login", width=10, command=login).pack(pady=10)

# Run the window
root.mainloop()
