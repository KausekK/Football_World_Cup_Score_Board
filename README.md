Do znajdowania konkretnego meczu użyłem mapy Map<MatchKey, Game>, ponieważ umożliwia ona szybki dostęp do meczu na podstawie pary nazw drużyn. Założyłem, że podczas Mistrzostw Świata jedna drużyna nie może grać jednocześnie w dwóch meczach, więc taka para drużyn jednoznacznie identyfikuje aktywne spotkanie.
Alternatywą mogłoby być przypisywanie unikalnych identyfikatorów (id) do meczów i używanie ich jako klucza w mapie. Byłoby to prostsze pod względem technicznym, ale wymagałoby dodatkowego zarządzania tymi identyfikatorami oraz zmuszałoby użytkownika do znajomości tego id, żeby odwołać się do konkretnego meczu.
Dlatego zdecydowałem się na podejście oparte na nazwach drużyn – jest bardziej naturalne dla użytkownika i pasuje do założeń projektu, w którym każdy mecz jest unikalny ze względu na grające zespoły.

Record MatchKey normalizuje nazwy drużyn (usuwa spacje, zamienia na wielkie litery), dzięki czemu nie ma problemów z duplikatami wynikającymi z literówek lub różnic w formacie.
