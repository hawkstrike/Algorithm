use std::io::stdin;

pub fn baekjoon_1001() {
    let mut input = String::new();
    
    stdin().read_line(&mut input).unwrap();
    
    let mut iter = input.split_whitespace();
    let a: i32 = iter.next().unwrap().parse().unwrap();
    let b: i32 = iter.next().unwrap().parse().unwrap();
    
    println!("{}", a - b);
}