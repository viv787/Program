from tkinter import *
from tkinter import messagebox

# Create main window
root = Tk()
root.title("Cab Booking App")
root.geometry("400x350")

# Heading
Label(root, text="Cab Booking Form", font=("Arial", 16, "bold")).pack(pady=10)

# Customer Name
Label(root, text="Customer Name:").pack()
name_var = StringVar()
Entry(root, textvariable=name_var, width=30).pack(pady=5)

# Pickup Location
Label(root, text="Pickup Location:").pack()
pickup_var = StringVar()
Entry(root, textvariable=pickup_var, width=30).pack(pady=5)

# Drop Location
Label(root, text="Drop Location:").pack()
drop_var = StringVar()
Entry(root, textvariable=drop_var, width=30).pack(pady=5)

# Function for booking
def book_cab():
    name = name_var.get()
    pickup = pickup_var.get()
    drop = drop_var.get()

    if name == "" or pickup == "" or drop == "":
        messagebox.showerror("Error", "Please fill all fields")
    else:
        messagebox.showinfo("Booking Confirmed",
                            f"Cab Booking Details:\n\nName: {name}\nPickup: {pickup}\nDrop: {drop}\n\nYour cab has been booked successfully!")

# Book Now button
Button(root, text="Book Now", width=15, command=book_cab).pack(pady=20)

root.mainloop()
