from tkinter import *
from tkinter import messagebox

# Create main window
root = Tk()
root.title("Student Registration Form")
root.geometry("400x450")

# Heading
Label(root, text="Student Registration Form", font=("Arial", 16, "bold")).pack(pady=10)

# Name
Label(root, text="Full Name:").pack()
name_var = StringVar()
Entry(root, textvariable=name_var, width=30).pack()

# Age
Label(root, text="Age:").pack()
age_var = StringVar()
Entry(root, textvariable=age_var, width=30).pack()

# Gender
Label(root, text="Gender:").pack()
gender_var = StringVar()
Radiobutton(root, text="Male", variable=gender_var, value="Male").pack()
Radiobutton(root, text="Female", variable=gender_var, value="Female").pack()

# Address
Label(root, text="Address:").pack()
address_text = Text(root, height=4, width=30)
address_text.pack()

# Hobbies
Label(root, text="Hobbies:").pack()
hobby_reading = BooleanVar()
hobby_music = BooleanVar()
hobby_sports = BooleanVar()

Checkbutton(root, text="Reading", variable=hobby_reading).pack()
Checkbutton(root, text="Music", variable=hobby_music).pack()
Checkbutton(root, text="Sports", variable=hobby_sports).pack()

# Submit button function
def submit():
    name = name_var.get()
    age = age_var.get()
    gender = gender_var.get()
    address = address_text.get("1.0", "end-1c")

    hobbies = []
    if hobby_reading.get():
        hobbies.append("Reading")
    if hobby_music.get():
        hobbies.append("Music")
    if hobby_sports.get():
        hobbies.append("Sports")

    if name == "" or age == "" or gender == "" or address == "":
        messagebox.showerror("Error", "Please fill all fields")
    else:
        info = f"Name: {name}\nAge: {age}\nGender: {gender}\nAddress: {address}\nHobbies: {', '.join(hobbies)}"
        messagebox.showinfo("Registration Successful", info)

# Submit Button
Button(root, text="Submit", command=submit).pack(pady=10)

root.mainloop()
