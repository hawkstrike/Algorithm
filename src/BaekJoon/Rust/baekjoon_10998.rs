
pub fn baekjoon_10998() {
    let mut input: String = String::new();
    
    std::io::stdin().read_line(&mut input).unwrap();
    
    let mut iter = input.split_whitespace();
    let a: i32 = iter.next().unwrap().parse().unwrap();
    let b: i32 = iter.next().unwrap().parse().unwrap();
    
    println!("{}", a * b);
}