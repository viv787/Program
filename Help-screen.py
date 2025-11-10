from tkinter import *
from tkinter import messagebox

# Create main window
root = Tk()
root.title("Help - My Application")
root.geometry("400x320")

# Heading
Label(root, text="Help & Support", font=("Arial", 16, "bold")).pack(pady=10)

# Instructions / Help Text
help_text = Text(root, height=10, width=45, wrap=WORD)
help_text.pack(pady=5)

# Insert help content
help_content = """Common Issues:
1. Make sure you have a stable internet connection.
2. To log in, use your registered username and password.
3. If you forgot your password, click on 'Forgot Password' on the login page.
4. For app updates, visit the official website.

For more help, contact:
📧 support@example.com
☎ +91 9876543210
"""
help_text.insert(END, help_content)
help_text.config(state=DISABLED)  # Make text read-only

# Button for feedback
def feedback():
    messagebox.showinfo("Feedback", "Thank you for your feedback! We’ll get back to you soon.")

Button(root, text="Send Feedback", width=15, command=feedback).pack(pady=15)

root.mainloop()
