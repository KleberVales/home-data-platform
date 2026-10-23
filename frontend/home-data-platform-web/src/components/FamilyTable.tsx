import type { FamilyMember } from "../services/familyService";

const formatDate = (iso: string) => {
  const [y, m, d] = iso.split("-");
  return y && m && d ? `${d}/${m}/${y}` : iso;
};

export function FamilyTable({ members }: { members: FamilyMember[] }) {
  if (members.length === 0) {
    return <p className="empty">Nenhum membro cadastrado. Preencha o formulário para adicionar o primeiro.</p>;
  }
  return (
    <div className="table-wrap">
      <table>
        <thead>
          <tr>
            <th>Nome</th><th>E-mail</th><th>Telefone</th><th>Parentesco</th><th>Nascimento</th>
          </tr>
        </thead>
        <tbody>
          {members.map((m) => (
            <tr key={m.id}>
              <td>{m.name}</td>
              <td>{m.email}</td>
              <td>{m.phone}</td>
              <td>{m.relationship}</td>
              <td>{formatDate(m.birthDate)}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}
