from tkinter import *
from tkinter import messagebox

# Create main window
root = Tk()
root.title("Sign-Up Window")
root.geometry("400x300")

# Heading
Label(root, text="Sign-Up Form", font=("Arial", 16, "bold")).pack(pady=10)

# Username
Label(root, text="Username:").pack()
username_var = StringVar()
Entry(root, textvariable=username_var, width=30).pack(pady=5)

# Email
Label(root, text="Email:").pack()
email_var = StringVar()
Entry(root, textvariable=email_var, width=30).pack(pady=5)

# Password
Label(root, text="Password:").pack()
password_var = StringVar()
Entry(root, textvariable=password_var, show="*", width=30).pack(pady=5)

# Confirm Password
Label(root, text="Confirm Password:").pack()
confirm_var = StringVar()
Entry(root, textvariable=confirm_var, show="*", width=30).pack(pady=5)

# Function for Sign-Up button
def signup():
    username = username_var.get()
    email = email_var.get()
    password = password_var.get()
    confirm = confirm_var.get()

    if username == "" or email == "" or password == "" or confirm == "":
        messagebox.showerror("Error", "Please fill all fields")
    elif password != confirm:
        messagebox.showerror("Error", "Passwords do not match")
    else:
        messagebox.showinfo("Success", f"Account created successfully!\nWelcome, {username}")

# Sign-Up button
Button(root, text="Sign Up", width=12, command=signup).pack(pady=10)

root.mainloop()
