def trim(s):
    if s==None:
        return s
    startIndex=0
    while startIndex<len(s) and s[startIndex]==' ':
        startIndex+=1
    endIndex=len(s)-1
    while endIndex>=0 and s[endIndex]==' ':
        endIndex-=1
    return s[startIndex:endIndex+1]

def main():
    # 测试:
    if trim('hello  ') != 'hello':
        print('1测试失败!')
    elif trim('  hello') != 'hello':
        print('2测试失败!')
    elif trim('  hello  ') != 'hello':
        print('3测试失败!')
    elif trim('  hello  world  ') != 'hello  world':
        print('4测试失败!')
    elif trim('') != '':
        print('5测试失败!')
    elif trim('    ') != '':
        print('6测试失败!')
    else:
        print('7测试成功!')

if __name__=='__main__':
    main()