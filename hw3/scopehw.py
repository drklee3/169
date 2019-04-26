def scope_test():
    def do_local():
         spam = "local spam"
    def do_nonlocal():
        nonlocal spam
        spam = "nonlocal spam"
    def do_global():
        global spam
        spam = "global spam"
    spam = "test spam"
    do_local()
    print("After local assignment:", spam)
    do_nonlocal()
    print("After nonlocal assignment:", spam)
    do_global()
    print("After global assignment:", spam)
scope_test()
print("In global scope:", spam)

# OUTPUT
# After local assignment: test spam
# After nonlocal assignment: nonlocal spam
# After global assignment: nonlocal spam
# In global scope: global spam



"""
do_local() makes a new spam variable within the function scope
which does not modify the spam function in scope_test()

do_nonlocal() uses the spam from scope_test() and modifies the value to "nonlocal spam"

do_global() makes a new global variable called spam and assigns the value "global spam"
but the print "after global assignment" prints the local spam variable which has "nonlocal spam"
still assigned to it from do_nonlocal()

after scope_test() the global spam variable is printed, which was set in do_global()
"""
