from tkinter import *
from tkinter import messagebox

# Create main window
root = Tk()
root.title("Sports Academy Registration Form")
root.geometry("400x450")

# Heading
Label(root, text="Sports Academy Registration", font=("Arial", 16, "bold")).pack(pady=10)

# Student Name
Label(root, text="Full Name:").pack()
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

# Choose Sport (Listbox)
Label(root, text="Select Sport:").pack(pady=5)
sport_listbox = Listbox(root, height=5)
sports = ["Cricket", "Football", "Badminton", "Tennis", "Basketball"]
for sport in sports:
    sport_listbox.insert(END, sport)
sport_listbox.pack()

# Function for submit button
def submit_form():
    name = name_var.get()
    age = age_var.get()
    gender = gender_var.get()

    selected = sport_listbox.curselection()
    sport = sport_listbox.get(selected) if selected else "Not selected"

    if name == "" or age == "" or gender == "":
        messagebox.showerror("Error", "Please fill all fields")
    else:
        messagebox.showinfo("Registration Successful",
                            f"Name: {name}\nAge: {age}\nGender: {gender}\nSport: {sport}")

# Submit Button
Button(root, text="Register", width=15, command=submit_form).pack(pady=20)

root.mainloop()
