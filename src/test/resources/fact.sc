fun factorial(n: int): int {
    var result = 1;
    while n > 0 {
        result = result * n;
        n = n - 1;
    }
    result
}