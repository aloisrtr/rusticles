fn power(base: int, exponent: int): int {
    if (exponent > 0) {
        base * power(base, exponent - 1)
    } else {
        1
    }
}