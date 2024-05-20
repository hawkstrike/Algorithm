use std::io::stdin;

pub fn baekjoon_15740() {
    let mut line: String = String::new();
    
    stdin().read_line(&mut line).unwrap();
    
    let mut iterator = line.split_whitespace();
    let a: i128 = iterator.next().unwrap().parse().unwrap();
    let b: i128 = iterator.next().unwrap().parse().unwrap();
    
    println!("{}", (a + b));
}