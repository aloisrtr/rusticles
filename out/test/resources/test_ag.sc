fn add(a: int, b: int): int {
    a + b
}

fn sub(a: int, b: int): int {
    a - b
}

fn mul(a: int, b: int): int {
    a * b
}

fn alu(op: int, a: int, b: int): int {
    if (op > 1) {
        add(a, b)
    } else if (op > 0) {
        sub(a, b)
    } else {
        mul(a, b)
    }
}
