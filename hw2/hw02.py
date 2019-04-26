def fun(x, y):
    """Returns x and y added together"""
    return x + y

# should return 3
print(fun(1, 2))
# should return "hithere"
print(fun("hi", "there"))

def report(xs):
    resp = [] # response "string"
    total = 0 # total points
    count = 0 # number of people
    i = 0     # position xs array
    while i < len(xs):
        # a single person's name
        name = []
        # while name
        while isinstance(xs[i], str):
            name.append(xs[i])
            i += 1
        
        # remove last name
        del name[-1]

        # add name to response
        resp.append(" ".join(name))

        total += xs[i]
        count += 1
        i += 1
    
    # add average to response
    resp.append("averaged " + str(total / count))

    return ", ".join(resp)

# should return "Jill, Billy Ray, Rita, Bobbie Sue, averaged 82.75"
print(report(["Jill", "Johnson", 87,
        "Billy", "Ray", "Cyrus", 78,
        "Rita", "Yeats", 94,
        "Bobbie", "Sue", "Palmer", 72]))