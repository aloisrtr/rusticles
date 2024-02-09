fun factorial(n: int): int {
    var result = 1;
    while n > 0 {
        result *= n;
        n -= 1;
    }
    result
}