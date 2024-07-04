use std::io::stdin;

pub fn baekjoon_1924() {
    const DAY_OF_WEEK: [&str; 7] = ["SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"];
    const DAY_OF_MONTH: [i32; 12] = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
    let month_day: Vec<i32> = stdin().lines().next().unwrap().unwrap()
        .split_whitespace().map(|s| s.parse::<i32>().unwrap()).collect::<Vec<i32>>();
    let (month, mut day) = (month_day[0], month_day[1]);
    
    for index in 0..(month - 1) {
        day += DAY_OF_MONTH[index as usize];
    }
    
    day %= 7;
    
    println!("{}", DAY_OF_WEEK[day as usize]);
}