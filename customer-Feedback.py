from tkinter import *
from tkinter import messagebox

# Create main window
root = Tk()
root.title("Customer Feedback Form")
root.geometry("400x350")

# Heading
Label(root, text="Hotel Food Feedback Form", font=("Arial", 16, "bold")).pack(pady=10)

# Customer Name
Label(root, text="Name:").pack()
name_var = StringVar()
Entry(root, textvariable=name_var, width=30).pack(pady=5)

# Email
Label(root, text="Email:").pack()
email_var = StringVar()
Entry(root, textvariable=email_var, width=30).pack(pady=5)

# Food Quality (Checkbuttons)
Label(root, text="How was the Food Quality?").pack(pady=5)
quality_good = BooleanVar()
quality_avg = BooleanVar()
quality_poor = BooleanVar()

Checkbutton(root, text="Good", variable=quality_good).pack(anchor="w", padx=30)
Checkbutton(root, text="Average", variable=quality_avg).pack(anchor="w", padx=30)
Checkbutton(root, text="Poor", variable=quality_poor).pack(anchor="w", padx=30)

# Function for submit button
def submit_feedback():
    name = name_var.get()
    email = email_var.get()

    if name == "" or email == "":
        messagebox.showerror("Error", "Please fill all fields")
        return

    quality = []
    if quality_good.get():
        quality.append("Good")
    if quality_avg.get():
        quality.append("Average")
    if quality_poor.get():
        quality.append("Poor")

    messagebox.showinfo("Feedback Received",
                        f"Thank you, {name}!\nYour Feedback:\nFood Quality: {', '.join(quality) if quality else 'Not selected'}")

# Submit Button
Button(root, text="Submit Feedback", command=submit_feedback).pack(pady=15)

root.mainloop()
