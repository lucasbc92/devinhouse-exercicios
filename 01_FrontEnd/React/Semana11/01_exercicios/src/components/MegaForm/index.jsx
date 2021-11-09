import { useState } from "react";
import { Selector } from "../Selector";

import "./styles.css";

const UF = [
  { value: "AC", label: "Acre" },
  { value: "AL", label: "Alagoas" },
  { value: "AP", label: "Amapá" },
  { value: "AM", label: "Amazonas" },
  { value: "BA", label: "Bahia" },
  { value: "CE", label: "Ceará" },
  { value: "DF", label: "Distrito Federal" },
  { value: "ES", label: "Espírito Santo" },
  { value: "GO", label: "Goías" },
  { value: "MA", label: "Maranhão" },
  { value: "MT", label: "Mato Grosso" },
  { value: "MS", label: "Mato Grosso do Sul" },
  { value: "MG", label: "Minas Gerais" },
  { value: "PA", label: "Pará" },
  { value: "PB", label: "Paraíba" },
  { value: "PR", label: "Paraná" },
  { value: "PE", label: "Pernambuco" },
  { value: "PI", label: "Piauí" },
  { value: "RJ", label: "Rio de Janeiro" },
  { value: "RN", label: "Rio Grande do Norte" },
  { value: "RS", label: "Rio Grande do Sul" },
  { value: "RO", label: "Rondônia" },
  { value: "RR", label: "Roraíma" },
  { value: "SC", label: "Santa Catarina" },
  { value: "SP", label: "São Paulo" },
  { value: "SE", label: "Sergipe" },
  { value: "TO", label: "Tocantins" },
];

export const MegaForm = () => {
  const [name, setName] = useState("");
  const [birthDate, setBirthDate] = useState("");
  const [favoriteAnimal, setFavoriteAnimal] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [passwordVerification, setPasswordVerification] = useState("");
  const [address, setAddress] = useState("");
  const [city, setCity] = useState("");
  const [uf, setUf] = useState("");
  const [phone, setPhone] = useState("+55");

  const handleChangeFavoriteAnimal = (value) => {
    if (value === favoriteAnimal) {
      setFavoriteAnimal("");
    } else {
      setFavoriteAnimal(value);
    }
  };

  function validateEmail(email) {
    const re =
      /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(String(email).toLowerCase());
  }

  const handleSubmit = async (e) => {
    e.preventDefault();
    if (name.length === 0) {
      alert("Please fill your name.");
      return;
    }
    if (birthDate.length === 0) {
      alert("Please fill your birth date.");
      return;
    }
    if (favoriteAnimal.length === 0) {
      alert("Please choose an animal.");
      return;
    }
    if (email.length === 0) {
      alert("Please fill your email.");
      return;
    }
    if (!validateEmail(email)) {
      alert("Email format is invalid.");
      return;
    }
    if (password.length < 8) {
      alert("Your password must have at least 8 characters.");
      return;
    }
    if (passwordVerification !== password) {
      alert("Both passwords must match.");
      return;
    }
    if (address.length === 0) {
      alert("Please fill your address.");
      return;
    }
    if (city.length === 0) {
      alert("Please fill your city.");
      return;
    }
    if (uf.length === 0) {
      alert("Please choose an state.");
      return;
    }
    if (phone.length === 0) {
      alert("Please fill your phone.");
      return;
    }
    if (!/\+55[0-9]{10,11}/.test(phone)) {
      alert("Phone is not in brazilian format.");
      return;
    }
    try {
      await fetch("http://localhost:3333/accounts", {
        method: "POST",
        headers: {
          Accept: "application/json",
          "Content-Type": "application/json",
        },
        body: JSON.stringify({
          name,
          birthDate,
          favoriteAnimal,
          email,
          password,
          address,
          city,
          uf,
          phone,
        }),
      });
      alert("Login successfully!");
    } catch (error) {
      alert(
        "Your account wasn't registered due to a server failure.\nSorry for the inconvenience!"
      );
    }
  };

  return (
    <form onSubmit={handleSubmit} className="mega-form-container">
      <h2>Personal</h2>
      <input
        type="text"
        name="name"
        placeholder="John Doe"
        value={name}
        onChange={(e) => setName(e.target.value)}
      ></input>
      <input
        type="date"
        name="birthDate"
        value={birthDate}
        onChange={(e) => setBirthDate(e.target.value)}
      ></input>
      <Selector
        label={"What's your favorite animal?"}
        options={["Lion", "Cat", "Dog", "Tiger"]}
        value={favoriteAnimal}
        onChange={handleChangeFavoriteAnimal}
      />
      <h2>Account</h2>
      <input
        type="text"
        name="email"
        placeholder="example@site.com"
        value={email}
        onChange={(e) => setEmail(e.target.value)}
      ></input>
      <input
        type="password"
        name="password"
        placeholder="Password"
        value={password}
        onChange={(e) => setPassword(e.target.value)}
      ></input>
      <input
        type="password"
        name="passwordVerification"
        placeholder="Verify your Password"
        value={passwordVerification}
        onChange={(e) => setPasswordVerification(e.target.value)}
      ></input>
      <h2>Contact</h2>
      <input
        type="text"
        name="address"
        placeholder="Address"
        value={address}
        onChange={(e) => setAddress(e.target.value)}
      ></input>
      <input
        type="text"
        name="city"
        placeholder="City"
        value={city}
        onChange={(e) => setCity(e.target.value)}
      ></input>
      <select value={uf} onChange={(event) => setUf(event.target.value)}>
        <option value="">Select your state</option>
        {UF.map((state) => (
          <option value={state.value}>{state.label}</option>
        ))}
      </select>
      <input
        type="text"
        name="phone"
        placeholder="+5548987654321"
        value={phone}
        onChange={(e) => setPhone(e.target.value)}
      ></input>
      <button type="submit">Create Account</button>
    </form>
  );
};
