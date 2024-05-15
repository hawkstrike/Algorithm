
pub fn baekjoon_1008() {
    let mut input = String::new();
    
    std::io::stdin().read_line(&mut input).unwrap();
    
    let mut iter = input.split_whitespace();
    let a: f64 = iter.next().unwrap().parse().unwrap();
    let b: f64 = iter.next().unwrap().parse().unwrap();
    
    println!("{}", a / b);
}