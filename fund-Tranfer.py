from tkinter import *
from tkinter import messagebox

# Create main window
root = Tk()
root.title("Fund Transfer")
root.geometry("400x350")

# Heading
Label(root, text="Fund Transfer Window", font=("Arial", 16, "bold")).pack(pady=10)

# Sender Name
Label(root, text="Sender Name:").pack()
sender_var = StringVar()
Entry(root, textvariable=sender_var, width=30).pack(pady=5)

# Receiver Name
Label(root, text="Receiver Name:").pack()
receiver_var = StringVar()
Entry(root, textvariable=receiver_var, width=30).pack(pady=5)

# Amount
Label(root, text="Amount (₹):").pack()
amount_var = StringVar()
Entry(root, textvariable=amount_var, width=30).pack(pady=5)

# Transfer Mode
Label(root, text="Transfer Mode:").pack()
mode_var = StringVar(value="Select")
modes = ["UPI", "Net Banking", "Credit Card", "Debit Card"]
OptionMenu(root, mode_var, *modes).pack(pady=5)

# Function for Submit button
def transfer():
    sender = sender_var.get()
    receiver = receiver_var.get()
    amount = amount_var.get()
    mode = mode_var.get()

    if sender == "" or receiver == "" or amount == "" or mode == "Select":
        messagebox.showerror("Error", "Please fill all fields")
    else:
        messagebox.showinfo("Transaction Successful",
                            f"Transfer Details:\n\nFrom: {sender}\nTo: {receiver}\nAmount: ₹{amount}\nMode: {mode}")

# Submit Button
Button(root, text="Transfer Funds", command=transfer).pack(pady=15)

root.mainloop()
