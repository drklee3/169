def print_list(input_):
    """A simple print function"""
    print(", ".join(str(x) for x in input_))

def partition(input_, p, r):
    """The partition function"""
    pivot = input_[r]

    while p < r:
        while input_[p] < pivot:
            p += 1
        
        while input_[r] > pivot:
            r -= 1
        
        if input_[p] == input_[r]:
            p += 1
        elif p < r:
            input_[p], input_[r] = input_[r], input_[p]
    
    return r

def quicksort(input_, p, r):
    """The quicksort recursive function"""
    if p < r:
        j = partition(input_, p, r)
        quicksort(input_, p,     j - 1)
        quicksort(input_, j + 1, r    )

def main():
    input_ = [500, 700, 800, 100, 300, 200, 900, 400, 1000, 600]
    print("Input: ", end = "")
    print_list(input_)

    quicksort(input_, 0, 9)
    print("Output: ", end = "")
    print_list(input_)

if __name__ == "__main__":
    main()
