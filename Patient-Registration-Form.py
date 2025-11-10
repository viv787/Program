from tkinter import *
from tkinter import messagebox

# Create main window
root = Tk()
root.title("Patient Registration Form")
root.geometry("400x400")  # Increased height for visibility

# Heading
Label(root, text="Hospital Patient Registration", font=("Arial", 16, "bold")).pack(pady=10)

# Patient Name
Label(root, text="Patient Name:").pack()
name_var = StringVar()
Entry(root, textvariable=name_var, width=30).pack(pady=5)

# Age
Label(root, text="Age:").pack()
age_var = StringVar()
Entry(root, textvariable=age_var, width=30).pack(pady=5)

# Gender
Label(root, text="Gender:").pack()
gender_var = StringVar()
Radiobutton(root, text="Male", variable=gender_var, value="Male").pack()
Radiobutton(root, text="Female", variable=gender_var, value="Female").pack()

# Address
Label(root, text="Address:").pack()
address_text = Text(root, height=4, width=30)
address_text.pack(pady=5)

# Submit Button Function
def submit_form():
    name = name_var.get()
    age = age_var.get()
    gender = gender_var.get()
    address = address_text.get("1.0", "end-1c")

    if name == "" or age == "" or gender == "" or address == "":
        messagebox.showerror("Error", "Please fill all fields")
    else:
        messagebox.showinfo("Registration Successful",
                            f"Name: {name}\nAge: {age}\nGender: {gender}\nAddress: {address}")

# Submit Button (now clearly visible)
Button(root, text="Register", width=15, height=1, command=submit_form).pack(pady=20)

# Run main loop
root.mainloop()
