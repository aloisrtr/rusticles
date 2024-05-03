fn sum(n: int): int {
    let result : int = 0;
    let i : int = 0;
    for { i = i + 1 } until i == n {
        result = result + i;
    };
    result
}
